# DupFiles

Assumption :

1.User always inputs absolute file path

2.FileName and size are factors for duplicate files

Scope for improvement:

1.User can have relative path or a directory name

2.Ingest filedata and hash it to find the duplicate file

Currently this program returns a Hashmap with key as FileDesc(has filename and size) and value as ArrayList which has all paths of a duplicate files.

