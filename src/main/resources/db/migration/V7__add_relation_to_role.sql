CREATE TABLE shop.user_role (

    user_id UUID REFERENCES shop.users(id) ON DELETE CASCADE,

    role_id UUID REFERENCES shop.roles(id) ON DELETE CASCADE,

    PRIMARY KEY(user_id, role_id)
);