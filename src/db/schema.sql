CREATE TYPE public.role AS ENUM
    ('ADMIN', 'BUYER', 'SELLER');

CREATE TABLE IF NOT EXISTS public.member
(
    id           bigserial                NOT NULL,
    member_id    text                     NOT NULL,
    phone_number text,
    created_at   timestamp with time zone NOT NULL,
    point        bigint                   NOT NULL,
    address      text,
    block_status boolean                  NOT NULL,
    hashed_pw    text                     NOT NULL,
    role         role                     NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.goods
(
    id          bigserial                NOT NULL,
    name        text                     NOT NULL,
    price       integer                  NOT NULL,
    description text                     NOT NULL,
    created_at  timestamp with time zone NOT NULL,
    view_count  integer                  NOT NULL,
    image_blob  bytea,
    updated_at  timestamp with time zone NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.bookmark
(
    goods_id  bigint NOT NULL,
    member_id bigint NOT NULL,
    FOREIGN KEY (goods_id)
        REFERENCES public.goods (id) MATCH SIMPLE
        ON UPDATE SET NULL
        ON DELETE SET NULL
        NOT VALID,
    FOREIGN KEY (member_id)
        REFERENCES public.member (id) MATCH SIMPLE
        ON UPDATE SET NULL
        ON DELETE SET NULL
        NOT VALID
);

CREATE TYPE public.category AS ENUM
    ('BAR', 'FOO', 'BAZ');

CREATE TABLE IF NOT EXISTS public.goods_category
(
    goods_id bigint NOT NULL,
    category category,
    PRIMARY KEY (goods_id, category),
    FOREIGN KEY (goods_id)
        REFERENCES public.goods (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public.purchase_history
(
    id         bigserial                NOT NULL,
    goods_id   bigint                   NOT NULL,
    member_id  bigint                   NOT NULL,
    content    text                     NOT NULL,
    rating     smallint                 NOT NULL,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT purchase_history_goods_id_fkey FOREIGN KEY (goods_id)
        REFERENCES public.goods (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT purchase_history_member_id_fkey FOREIGN KEY (member_id)
        REFERENCES public.member (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
);
