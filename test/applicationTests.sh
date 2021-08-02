cd ../src || exit
cp Application.java ../test
cd ../test || exit

javac Application.java
java Application >inputFromApplication.txt

expected="xxxx"
echo $expected >expected.txt

echo "Checking if output is equal: \"xxxx\""
if [ "$expected" == "$(cat inputFromApplication.txt)" ]; then
  echo "Test passed"
else
  echo "Test failed"
  diff -u --color ./inputFromApplication.txt ./expected.txt
fi

read -n 1 -p "Press any key to exit..."

rm Application.java Application.class inputFromApplication.txt expected.txt
