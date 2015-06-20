-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212') 
insert into tb_pessoa(cpf,nome,versao) values('123.456.789-10','FULANINHO SILVA SAURO',1)
insert into tb_pessoa(cpf,nome,versao) values('123.456.789-12','CICRANINHO SILVA SAURO',1)
insert into tb_pessoa(cpf,nome,versao) values('123.456.789-15','BELTRANINHO SILVA SAURO',1)
insert into tb_pessoa(cpf,nome,versao) values('123.456.789-14','BAR SILVA SAURO',1)
insert into tb_pessoa(cpf,nome,versao) values('123.456.789-19','FOO SILVA SAURO',1)
insert into tb_pessoa(cpf,nome,versao) values('123.456.789-18','FULANINHA SILVA SAURO',1)
insert into tb_aluno(data_aniversario,matricula,id) values('1995-04-11',1234567,1)
insert into tb_aluno(data_aniversario,matricula,id) values('1992-02-14',1234887,2)
insert into tb_aluno(data_aniversario,matricula,id) values('1994-08-02',1234447,3)
insert into tb_professor(salario,id) values(2000,4)
insert into tb_professor(salario,id) values(1000,5)
insert into tb_professor(salario,id) values(5000,6)
insert into tb_sala(id,codigo,capacidade,flg_quadro_branco,flg_data_show,flg_computador,observacao,status,data_termino_manut,versao) values(1,'12345',40,true,false,false,'Observação xyz',1,'2010-10-04',1)
insert into tb_sala(id,codigo,capacidade,flg_quadro_branco,flg_data_show,flg_computador,observacao,status,data_termino_manut,versao) values(2,'123456',450,true,true,true,null,2,null,1)
insert into tb_sala(id,codigo,capacidade,flg_quadro_branco,flg_data_show,flg_computador,observacao,status,data_termino_manut,versao) values(3,'1234567',100,true,false,true,'Observação xyz',3,'2014-10-04',1)
insert into tb_disciplina(id,versao,bibliografia,cargaHoraria,curso,distribuicaoAvaliacao,ementa,nome,observacao,tipo,id_professor_fk,id_sala_fk) values(1,1,'Bibliografia da disciplina XYZ Exemplo LIVRO XYZ LIXO ABC LIVRO EFG LIVRO HIJ',200,'SIT','DAD AIA AF','ASSUNTOS TAIS ETC ASSUNTO 1 ASSUNTO 2 ASSUNTO 3 ASSUNTO 4','POO','OBS POO',1,4,1)
insert into tb_disciplina(id,versao,bibliografia,cargaHoraria,curso,distribuicaoAvaliacao,ementa,nome,observacao,tipo,id_professor_fk,id_sala_fk) values(2,1,'Bibliografia da disciplina FOO Exemplo LIVRO XYZ LIXO ABC LIVRO EFG LIVRO HIJ',200,'SIT','DAD AIA AF','ASSUNTOS TAIS ETC ASSUNTO 1 ASSUNTO 2 ASSUNTO 3 ASSUNTO 4','ENGENHARIA DE SOFTWARE','OBS ENGENHARIA',1,5,2)
insert into tb_disciplina(id,versao,bibliografia,cargaHoraria,curso,distribuicaoAvaliacao,ementa,nome,observacao,tipo,id_professor_fk,id_sala_fk) values(3,1,'Bibliografia da disciplina BAR Exemplo LIVRO XYZ LIXO ABC LIVRO EFG LIVRO HIJ',200,'SIT','DAD AIA AF','ASSUNTOS TAIS ETC ASSUNTO 1 ASSUNTO 2 ASSUNTO 3 ASSUNTO 4','ALGORITMO E ESTRUTURA DE DADOS','OBS AEDS',2,6,3)
insert into tb_disciplina_tem_alunos(id_disciplina_fk,id_aluno_fk) values(1,1);
insert into tb_disciplina_tem_alunos(id_disciplina_fk,id_aluno_fk) values(1,2);
insert into tb_disciplina_tem_alunos(id_disciplina_fk,id_aluno_fk) values(1,3);
insert into tb_disciplina_tem_alunos(id_disciplina_fk,id_aluno_fk) values(2,1);
insert into tb_disciplina_tem_alunos(id_disciplina_fk,id_aluno_fk) values(2,2);
insert into tb_disciplina_tem_alunos(id_disciplina_fk,id_aluno_fk) values(3,1);
insert into tb_disciplina_tem_alunos(id_disciplina_fk,id_aluno_fk) values(3,2);
insert into tb_disciplina_tem_alunos(id_disciplina_fk,id_aluno_fk) values(3,3);