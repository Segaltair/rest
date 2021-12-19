CREATE SCHEMA IF NOT EXISTS "REST";

CREATE TABLE "REST"."customer"
(
    "id" uuid PRIMARY KEY,
    "title"       varchar(255) NOT NULL,
    "is_deleted"  boolean      NOT NULL,
    "created_at"  timestamp    NOT NULL,
    "modified_at" timestamp    NULL
);

CREATE TABLE "REST"."product"
(
    "id" uuid PRIMARY KEY,
    "customer_id" uuid NOT NULL,
    "title"       varchar(255) NOT NULL,
    "description" text         NULL,
    "price"       numeric      NOT NULL,
    "is_deleted"  boolean      NOT NULL,
    "created_at"  timestamp    NOT NULL,
    "modified_at" timestamp    NULL,
    CONSTRAINT product_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES "REST".customer (id)
);
