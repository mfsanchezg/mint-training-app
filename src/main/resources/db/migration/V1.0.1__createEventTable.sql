CREATE TABLE public.event (
                                id_event integer GENERATED ALWAYS AS IDENTITY,
                                id_instructor integer not NULL,
                                event_type varchar(10) not null,
                                initial_date timestamp not null,
                                final_date timestamp not null,
                                description varchar(100),
                                constraint fk_instructor foreign key(id_instructor) references public.instructor(id_instructor)
);
