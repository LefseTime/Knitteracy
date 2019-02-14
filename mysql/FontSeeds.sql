insert into Font (name, height, description, sourceName, sourceUrl)
	values ("Basic Block Caps",7,"Low resolution block capital letters","Flickr","https://www.flickr.com/photos/59646927@N00/6604369855");
    
insert into Font (name, height, description, sourceName, sourceUrl)
	values ("Magical Wizard",15,"A font from a very popular magical book series.","The Wandering Interrobang","http://wanderinginterrobang.blogspot.com/2012/07/potter-alphabet-for-knitting.html");

insert into Font (name, height, description, sourceName, sourceUrl)
	values ("Baseline Lowercase",9,"An all lower-case font with no descenders.","Pinterest","https://www.pinterest.com/pin/find/?url=https%3A%2F%2Fusefulresults.com%2Fphoto%2Fuse-these-handy-alphabet-charts-for-knitting-words-or.html");

insert into Font (name, height, description, sourceName, sourceUrl)
	values ("Block Caps",9,"A capital letter alphabet.","Yarn Tree","http://yarntree.com/035alph.htm");
    
insert into Font (name, height, description, sourceName, sourceUrl)
	values ("Lowercase",9,"A lowercase alphabet.","Yarn Tree","http://yarntree.com/035alph.htm");
    
insert into Font (name, height, description, sourceName, sourceUrl)
	values ("Lightly-serifed Lowercase",14,"A lowercase alphabet with light serifs.","Ravelry - alfa knits","https://www.ravelry.com/patterns/library/alphabet--signs");

select * from Letter where fontId = 7;

use KnittingChart;
delete from Chart;
select * from Font;

-- INSERT INTO chart (kerning, spacing, text, fontId, username) VALUES (2, 2, "cheese",6, "beef");

-- insert into Chart (username, fontId, text, kerning, spacing)
-- 	values ("beef",2,"beef",1,2);
--     
--     SELECT * FROM chart 
--                     JOIN font ON chart.fontId = font.fontId 
--                     WHERE username = 'cornedbeef';