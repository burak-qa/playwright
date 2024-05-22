# playwright

---record-----
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen google.com"

---start trace.zip----
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace target//trace.zip"


----run configuration > environment variables----
PWDEBUG=1
