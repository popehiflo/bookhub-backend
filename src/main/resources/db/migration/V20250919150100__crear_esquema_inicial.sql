-- Elimina el schema 'public' por defecto para asegurar que solo se utilice el schema de la aplicación.
DROP SCHEMA IF EXISTS public CASCADE;

-- Crea el schema 'dbo' (Database Owner) si no existe previamente.
CREATE SCHEMA IF NOT EXISTS dbo;