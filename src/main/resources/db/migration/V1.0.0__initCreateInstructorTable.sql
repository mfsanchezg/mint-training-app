CREATE TABLE public.instructor (
                                id_instructor integer GENERATED ALWAYS AS IDENTITY,
                                name character varying(255),
                                birth_day date not null,
                                UNIQUE (id_instructor)
);
