DROP TABLE moviehall."Role";
ALTER TABLE moviehall."User" DROP COLUMN password;
ALTER TABLE moviehall."UserRole" RENAME COLUMN role_id TO role;
