CREATE TABLE "SubscriptionsUser" (
                                     "id" bigint GENERATED ALWAYS AS IDENTITY,
                                     "userSubject" bigint NOT NULL,
                                     "userObject" bigint NOT NULL,
                                     CONSTRAINT "SubscriptionsUser_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Messages" (
                            "id" bigint GENERATED ALWAYS AS IDENTITY,
                            "text" varchar(10000) NOT NULL,
                            "from" bigint NOT NULL,
                            "to" bigint NOT NULL,
                            "date" TIMESTAMP NOT NULL,
                            CONSTRAINT "Messages_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Users" (
                         "id" bigint GENERATED ALWAYS AS IDENTITY,
                         "name" varchar(255) NOT NULL,
                         "avatar" bigint,
                         "regDate" DATE NOT NULL,
                         "type" bigint NOT NULL,
                         CONSTRAINT "Users_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "UsersAvatars" (
                                "id" bigint GENERATED ALWAYS AS IDENTITY,
                                "photo" bytea NOT NULL,
                                CONSTRAINT "UsersAvatars_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Reasons" (
                           "id" bigint GENERATED ALWAYS AS IDENTITY,
                           "name" varchar(1000) NOT NULL UNIQUE,
                           CONSTRAINT "Reasons_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Blockings" (
                             "id" bigint GENERATED ALWAYS AS IDENTITY,
                             "user" bigint NOT NULL,
                             "reason" bigint NOT NULL,
                             "time" int NOT NULL,
                             "blockDate" TIMESTAMP NOT NULL,
                             CONSTRAINT "Blockings_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Strikes" (
                           "id" bigint GENERATED ALWAYS AS IDENTITY,
                           "user" bigint NOT NULL,
                           "reason" bigint NOT NULL,
                           CONSTRAINT "Strikes_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Categories" (
                              "id" bigint GENERATED ALWAYS AS IDENTITY,
                              "name" varchar(100) NOT NULL UNIQUE,
                              CONSTRAINT "Categories_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "SubscriptionsCategory" (
                                         "id" bigint GENERATED ALWAYS AS IDENTITY,
                                         "user" bigint NOT NULL,
                                         "category" bigint NOT NULL,
                                         CONSTRAINT "SubscriptionsCategory_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "StatusAds" (
                             "id" bigint GENERATED ALWAYS AS IDENTITY,
                             "name" varchar(100) NOT NULL UNIQUE,
                             CONSTRAINT "StatusAds_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Advertisements" (
                                  "id" bigint GENERATED ALWAYS AS IDENTITY,
                                  "header" varchar(1000) NOT NULL,
                                  "description" varchar(10000) NOT NULL,
                                  "price" float4 NOT NULL,
                                  "category" bigint NOT NULL,
                                  "author" bigint NOT NULL,
                                  "publicationDate" TIMESTAMP NOT NULL,
                                  "countWatch" int NOT NULL DEFAULT '0',
                                  "status" bigint NOT NULL,
                                  "editDate" TIMESTAMP NOT NULL,
                                  CONSTRAINT "Advertisements_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "AdsPhotos" (
                             "ads" bigint NOT NULL,
                             "photo" bytea NOT NULL,
                             CONSTRAINT "AdsPhotos_pk" PRIMARY KEY ("ads")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Bookings" (
                            "id" bigint GENERATED ALWAYS AS IDENTITY,
                            "ads" bigint NOT NULL,
                            "claimant" bigint NOT NULL,
                            "dateStart" TIMESTAMP NOT NULL,
                            "dateUntil" TIMESTAMP NOT NULL,
                            CONSTRAINT "Bookings_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Purchases" (
                             "id" bigint GENERATED ALWAYS AS IDENTITY,
                             "ads" bigint NOT NULL,
                             "seller" bigint NOT NULL,
                             "buyer" bigint,
                             "price" float4 NOT NULL,
                             "date" TIMESTAMP NOT NULL,
                             CONSTRAINT "Purchases_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Favourites" (
                              "id" bigint GENERATED ALWAYS AS IDENTITY,
                              "ads" bigint NOT NULL,
                              "user" bigint NOT NULL,
                              "dateAdd" TIMESTAMP NOT NULL,
                              CONSTRAINT "Favourites_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "UserTypes" (
                             "id" bigint GENERATED ALWAYS AS IDENTITY,
                             "type" varchar(100) NOT NULL UNIQUE,
                             CONSTRAINT "UserTypes_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



ALTER TABLE "SubscriptionsUser" ADD CONSTRAINT "SubscriptionsUser_fk0" FOREIGN KEY ("userSubject") REFERENCES "Users"("id");
ALTER TABLE "SubscriptionsUser" ADD CONSTRAINT "SubscriptionsUser_fk1" FOREIGN KEY ("userObject") REFERENCES "Users"("id");

ALTER TABLE "Messages" ADD CONSTRAINT "Messages_fk0" FOREIGN KEY ("from") REFERENCES "Users"("id");
ALTER TABLE "Messages" ADD CONSTRAINT "Messages_fk1" FOREIGN KEY ("to") REFERENCES "Users"("id");

ALTER TABLE "Users" ADD CONSTRAINT "Users_fk0" FOREIGN KEY ("avatar") REFERENCES "UsersAvatars"("id");
ALTER TABLE "Users" ADD CONSTRAINT "Users_fk1" FOREIGN KEY ("type") REFERENCES "UserTypes"("id");



ALTER TABLE "Blockings" ADD CONSTRAINT "Blockings_fk0" FOREIGN KEY ("user") REFERENCES "Users"("id");
ALTER TABLE "Blockings" ADD CONSTRAINT "Blockings_fk1" FOREIGN KEY ("reason") REFERENCES "Reasons"("id");

ALTER TABLE "Strikes" ADD CONSTRAINT "Strikes_fk0" FOREIGN KEY ("user") REFERENCES "Users"("id");
ALTER TABLE "Strikes" ADD CONSTRAINT "Strikes_fk1" FOREIGN KEY ("reason") REFERENCES "Reasons"("id");


ALTER TABLE "SubscriptionsCategory" ADD CONSTRAINT "SubscriptionsCategory_fk0" FOREIGN KEY ("user") REFERENCES "Users"("id");
ALTER TABLE "SubscriptionsCategory" ADD CONSTRAINT "SubscriptionsCategory_fk1" FOREIGN KEY ("category") REFERENCES "Categories"("id");


ALTER TABLE "Advertisements" ADD CONSTRAINT "Advertisements_fk0" FOREIGN KEY ("category") REFERENCES "Categories"("id");
ALTER TABLE "Advertisements" ADD CONSTRAINT "Advertisements_fk1" FOREIGN KEY ("author") REFERENCES "Users"("id");
ALTER TABLE "Advertisements" ADD CONSTRAINT "Advertisements_fk2" FOREIGN KEY ("status") REFERENCES "StatusAds"("id");

ALTER TABLE "AdsPhotos" ADD CONSTRAINT "AdsPhotos_fk0" FOREIGN KEY ("ads") REFERENCES "Advertisements"("id");

ALTER TABLE "Bookings" ADD CONSTRAINT "Bookings_fk0" FOREIGN KEY ("ads") REFERENCES "Advertisements"("id");
ALTER TABLE "Bookings" ADD CONSTRAINT "Bookings_fk1" FOREIGN KEY ("claimant") REFERENCES "Users"("id");

ALTER TABLE "Purchases" ADD CONSTRAINT "Purchases_fk0" FOREIGN KEY ("ads") REFERENCES "Advertisements"("id");
ALTER TABLE "Purchases" ADD CONSTRAINT "Purchases_fk1" FOREIGN KEY ("seller") REFERENCES "Users"("id");
ALTER TABLE "Purchases" ADD CONSTRAINT "Purchases_fk2" FOREIGN KEY ("buyer") REFERENCES "Users"("id");

ALTER TABLE "Favourites" ADD CONSTRAINT "Favourites_fk0" FOREIGN KEY ("ads") REFERENCES "Advertisements"("id");
ALTER TABLE "Favourites" ADD CONSTRAINT "Favourites_fk1" FOREIGN KEY ("user") REFERENCES "Users"("id");


















