/*
Following SQL queries create input and output tables.
*/

create table input_table (id integer, home_page integer, product_page integer, warranty_page integer);
		insert into input_table (id, home_page, product_page, warranty_page) values (1, 1, 1, 1);
        insert into input_table (id, home_page, product_page, warranty_page) values (2, 1, 1, 0);
        insert into input_table (id, home_page, product_page, warranty_page) values (3, 1, 0, 1);
        insert into input_table (id, home_page, product_page, warranty_page) values (4, 1, 0, 0);
        insert into input_table (id, home_page, product_page, warranty_page) values (5, 0, 1, 1);
        insert into input_table (id, home_page, product_page, warranty_page) values (6, 0, 1, 0);
        insert into input_table (id, home_page, product_page, warranty_page) values (7, 0, 0, 1);
        insert into input_table (id, home_page, product_page, warranty_page) values (8, 0, 0, 0);
		select * from input_table;
        
create table output_table (page integer, counts integer);

/*
Following SQL queries count the number of respective pages from input table and copies it to output 
table.
*/

insert into output_table (page, count)
values ("Home_Page", (select count(*) 
from input_table 
where home_page=1));

insert into output_table (page, count)
values ("Product_Page", (select count(*) 
from input_table 
where product_page=1));

insert into output_table (page, count)
values ("Warranty_Page", (select count(*) 
from input_table 
where warranty_page=1));	