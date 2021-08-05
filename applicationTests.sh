outputFromApplication=$(java Application.java)
expected="xxxx"

echo "Checking if output is equal: $expected"
diff -u --color <(echo "$expected") <(echo "$outputFromApplication") || read -n 1 -p "Process finished with exit code 1: Test failed"
