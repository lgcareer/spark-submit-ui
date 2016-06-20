# --- Initiali DB schema for identity management

# --- !Ups
create table user (
  email                     varchar(255) not null primary key,
  name                      varchar(255) not null,
  password                  varchar(255) not ,
  status                    int(4)  NOT NULL DEFAULT 0
);


# --- !Downs

drop table if exists user;
