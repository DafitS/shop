Create SCHEMA shop;
Create Table shop.users (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    first_name VARCHAR(255) NOT NULL,

    last_name VARCHAR(255) NOT NULL,

    email VARCHAR(255) NOT NULL,

    password VARCHAR(255) NOT NULL,

    active BOOLEAN DEFAULT false
);