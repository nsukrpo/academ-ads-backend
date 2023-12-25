package nsukrpo.backend.services.impls;

import nsukrpo.backend.config.BlockReason;
import nsukrpo.backend.model.dtos.BlockingDto;
import nsukrpo.backend.model.dtos.BlockingPostDto;
import nsukrpo.backend.model.dtos.BlockingPutDto;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.entities.moderation.Block;
import nsukrpo.backend.repository.moderation.BlockingRep;
import nsukrpo.backend.services.BlockingService;
import nsukrpo.backend.services.impls.utils.BlockingManager;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BlockingServiceImpl implements BlockingService {
    private final BlockingRep blockingRep;
    private final BlockingManager blockingManager;
    private final UserManager userManager;

    @Autowired
    public BlockingServiceImpl(BlockingRep blockingRep, BlockingManager blockingManager, UserManager userManager){
        this.blockingRep = blockingRep;
        this.blockingManager = blockingManager;
        this.userManager = userManager;
    }
    @Override
    public BlockingDto getBlocking(Long id) {
        Block block = blockingManager.getBlockOrThrow(id);
        return new BlockingDto(block);
    }

    @Override
    public IdDto putBlocking(Long id, BlockingPutDto body) {
        Block block = blockingManager.getBlockOrThrow(id);
        Optional.ofNullable(body.getUser()).map(userManager::getUserOrThrow).ifPresent(block::setUser);
        Optional.ofNullable(body.getReason()).map(BlockReason::valueOf).map(blockingManager::getReasonOrThrow).ifPresent(block::setReason);
        Optional.ofNullable(body.getTime()).ifPresent(block::setTime);
        blockingRep.save(block);
        return new IdDto(block.getId());
    }

    @Override
    public HttpStatus deleteBlocking(Long id) {
        blockingRep.delete(blockingManager.getBlockOrThrow(id));
        return HttpStatus.OK;
    }

    @Override
    public List<BlockingDto> getUserBlocking(Long userId) {
        Iterable<Block> userBlocksSet = Optional.ofNullable(userId).map(id -> (Iterable<Block>) userManager.getUserOrThrow(id).getBlocks()).orElse(blockingRep.findAll());
        List<BlockingDto> userBlocks = new ArrayList<>();
        for (Block block: userBlocksSet)
            userBlocks.add(new BlockingDto(block));
        return userBlocks;
    }

    @Override
    public IdDto postBlocking(BlockingPostDto body) {
        Block block = Block.builder()
                .user(userManager.getUserOrThrow(body.getUserId()))
                .reason(blockingManager.getReasonOrThrow(BlockReason.valueOf(body.getReason())))
                .time(body.getTimeMinutes())
                .blockDate(new Timestamp(System.currentTimeMillis()))
                .build();
        block = blockingRep.save(block);
        return new IdDto(block.getId());
    }
}
