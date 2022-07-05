
    create table comments (
       id bigint not null auto_increment,
        body varchar(255) not null,
        email varchar(255) not null,
        name varchar(255) not null,
        post_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table likes (
       id bigint not null auto_increment,
        comment_id bigint,
        post_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table posts (
       id bigint not null auto_increment,
        content varchar(255) not null,
        description varchar(255) not null,
        title varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table roles (
       id bigint not null auto_increment,
        name varchar(32) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_roles (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB;

    create table users (
       id bigint not null auto_increment,
        email varchar(255) not null,
        gender varchar(255),
        name varchar(255) not null,
        password varchar(255) not null,
        age integer,
        city varchar(255),
        description longtext,
        username varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table posts 
       add constraint UK_mchce1gm7f6otpphxd6ixsdps unique (title);

    alter table users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table comments 
       add constraint FKh4c7lvsc298whoyd4w9ta25cr 
       foreign key (post_id) 
       references posts (id);

    alter table user_roles 
       add constraint FKh8ciramu9cc9q3qcqiv4ue8a6 
       foreign key (role_id) 
       references roles (id);

    alter table user_roles 
       add constraint FKhfh9dx7w3ubf1co1vdev94g3f 
       foreign key (user_id) 
       references users (id);
