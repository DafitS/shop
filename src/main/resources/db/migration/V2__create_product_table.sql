
CREATE TABLE shop.products (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    name VARCHAR(255) NOT NULL,

    price DECIMAL(10, 2) NOT NULL,

    quantity BIGINT DEFAULT 10,

    serial_number VARCHAR(255) NOT NULL,

    active BOOLEAN DEFAULT false
);