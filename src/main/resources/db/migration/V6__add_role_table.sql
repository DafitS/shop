CREATE TABLE shop.roles (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    name VARCHAR(40) NOT NULL
);