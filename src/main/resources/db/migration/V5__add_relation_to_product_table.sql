ALTER TABLE shop.products
ADD COLUMN category_id UUID;

ALTER TABLE shop.products
ADD CONSTRAINT fk_product_category
FOREIGN KEY (category_id)
REFERENCES shop.categories(id);

