-- Migration para adicionar a coluna de rank na tb_cadastro

ALTER TABLE TB_CADASTRO
ADD COLUMN rank VARCHAR(255);