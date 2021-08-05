cd ../src || exit
javac Application.java
outputFromApplication=$(java Application)

expected="xxxx"

echo "Checking if output is equal: \"xxxx\""
if [ "$expected" == "$outputFromApplication" ]; then
  echo "Test passed"
else
  echo "Test failed"
  echo "Output from application: $outputFromApplication"
  echo "Expected value: $expected"
  read -n 1 -p "Press any key to exit..."
fi

rm ../src/Application.class
