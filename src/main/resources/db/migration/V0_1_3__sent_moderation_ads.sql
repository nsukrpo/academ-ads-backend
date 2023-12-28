ALTER TABLE "Favourites"
    ADD CONSTRAINT uq_Favourites UNIQUE("ads", "user");