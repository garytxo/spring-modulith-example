create table if not exists orders
(
    id uuid primary key not null,
    description text default null,

    row_version    integer      DEFAULT 0     NOT NULL,
    row_created_on timestamp    DEFAULT now() NOT NULL,
    row_updated_on timestamp    DEFAULT now()
);

create table if not exists orders_line_items
(
    id uuid primary key not null,
    product int not null ,
    quantity int not null,
    orders_id uuid references orders(id),

    row_version    integer      DEFAULT 0     NOT NULL,
    row_created_on timestamp    DEFAULT now() NOT NULL,
    row_updated_on timestamp    DEFAULT now()
);