echo 4 | java Application.java > output.txt

diff -u --color ./output.txt ./expected.txt && rm output.txt