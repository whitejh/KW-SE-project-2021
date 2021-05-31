CREATE TYPE public.role AS ENUM
    ('ADMIN', 'CONSUMER', 'SELLER');

CREATE TABLE IF NOT EXISTS public.member
(
    id           text                     NOT NULL,
    phone_number text,
    created_at   timestamp with time zone NOT NULL,
    point        bigint                   NOT NULL,
    address      text,
    block_status boolean                  NOT NULL,
    role         role                     NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.goods
(
    id          bigserial                NOT NULL,
    seller_id   text                     NOT NULL,
    name        text                     NOT NULL,
    price       integer                  NOT NULL,
    description text                     NOT NULL,
    created_at  timestamp with time zone NOT NULL,
    view_count  integer                  NOT NULL,
    image       text,
    updated_at  timestamp with time zone NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (seller_id)
        REFERENCES public.member (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public.bookmark
(
    goods_id  bigint NOT NULL,
    member_id text   NOT NULL,
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
    ('TSHIRT', 'SHIRT');

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
    member_id  text                     NOT NULL,
    content    text                     NOT NULL,
    rating     smallint                 NOT NULL,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (goods_id)
        REFERENCES public.goods (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    FOREIGN KEY (member_id)
        REFERENCES public.member (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

CREATE TYPE public.order_status AS ENUM
    ('READY', 'DONE');


CREATE TABLE IF NOT EXISTS public.order_
(
    id          bigserial    NOT NULL,
    goods_id    bigint       NOT NULL,
    consumer_id text         NOT NULL,
    status      order_status NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (goods_id)
        REFERENCES public.goods (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    FOREIGN KEY (consumer_id)
        REFERENCES public.member (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
)
