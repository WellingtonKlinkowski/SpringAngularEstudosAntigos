create table alunos (
       id  serial not null,
        cpf varchar(255) UNIQUE,
        email varchar(255) UNIQUE,
        nome varchar(255) UNIQUE,
        primary key (id)
    );

     create table professor (
            id serial not null,
            cpf varchar(255) UNIQUE,
            email varchar(255) UNIQUE,
            nome varchar(255) UNIQUE,
            primary key (id)
        );

    create table materia (
        id serial not null,
        nome varchar(255) UNIQUE,
        descricao varchar(255),
        id_professor int ,
        primary key (id)
    );


    create table matricula (
        id  serial not null,
        data date,
        id_alunos INT,
        id_materia int,
        primary key (id)
    );

    alter table materia
       add constraint FK_id_professor
       foreign key (id_professor)
       references professor(id);


    alter table matricula
       add constraint FK_id_materia
       foreign key (id_materia)
       references materia(id);


    alter table matricula
       add constraint FK_id_alunos
       foreign key (id_alunos)
       references alunos(id);


