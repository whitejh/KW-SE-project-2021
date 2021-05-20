CREATE TABLE IF NOT EXISTS public.member
(
    id bigserial NOT NULL,
    phone_number text,
    created_at timestamp with time zone NOT NULL,
    point bigint NOT NULL,
    address text,
    block_status boolean NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.member
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.goods
(
    id bigint NOT NULL DEFAULT nextval('goods_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    price integer,
    description text COLLATE pg_catalog."default",
    created_at timestamp with time zone,
    view_count integer,
    image_blob bytea,
    updated_at timestamp with time zone,
    CONSTRAINT goods_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.goods
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.bookmark
(
    goods_id bigint,
    member_id bigint,
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

ALTER TABLE public.bookmark
    OWNER to postgres;


CREATE TYPE public.category AS ENUM
    ('BAR', 'FOO', 'BAZ');

ALTER TYPE public.category
    OWNER TO postgres;


CREATE TABLE IF NOT EXISTS public.goods_category
(
    goods_id bigserial NOT NULL,
    category category,
    PRIMARY KEY (goods_id),
    FOREIGN KEY (goods_id)
        REFERENCES public.goods (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

ALTER TABLE public.goods_category
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.purchase_history
(
    id bigint NOT NULL DEFAULT nextval('purchase_history_id_seq'::regclass),
    goods_id bigint NOT NULL,
    member_id bigint NOT NULL,
    content text COLLATE pg_catalog."default" NOT NULL,
    rating smallint NOT NULL,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL,
    CONSTRAINT purchase_history_pkey PRIMARY KEY (id),
    CONSTRAINT purchase_history_goods_id_fkey FOREIGN KEY (goods_id)
        REFERENCES public.goods (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT purchase_history_member_id_fkey FOREIGN KEY (member_id)
        REFERENCES public.member (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

ALTER TABLE public.purchase_history
    OWNER to postgres;
