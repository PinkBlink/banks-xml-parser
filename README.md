# XML File with Bank Deposits

## Task Description
Create an XML file that stores information about objects in a specific domain. To validate the resulting XML file, develop a corresponding XSD schema. Parse the XML document using DOM, SAX, and StAX parsers.

## Requirements
- Use both **required** and **optional** elements.
- Include **enumerations**.
- Apply **patterns** and **boundary values**.
- Utilize the **ID type**.
- Use at least 2 **attributes** in arbitrary positions within the XML file.
- Define **default attribute values**.
- Incorporate **date-time** elements.
- Ensure the XML document contains at least **16 entities**.
- Organize parsers using the **Builder design pattern**.
- Use **Log4J2** or **SLF4J** for logging.
- The code must be covered with **tests**.
- The project should not contain a `main` method. Execution must be performed through tests.

## Domain: Bank Deposits
### Elements to include:
- **Name**: The name of the bank.
- **Country**: The country of registration.
- **Type**: The type of deposit (demand, term, settlement, cumulative, savings, metal).
- **Depositor**: The name of the depositor.
- **Account ID**: The account number.
- **Amount on Deposit**: The deposit amount.
- **Profitability**: The annual interest rate.
- **Time Constraints**: The deposit duration.

### Root Element
The root element of the XML document should be named `Banks`.

## Example Workflow
1. **Design the XSD Schema**: Ensure it adheres to the specified requirements, including enumerations, patterns, and attributes.
2. **Generate the XML File**: Populate it with at least 16 entities following the XSD rules.
3. **Parse the XML Document**: Implement parsers using DOM, SAX, and StAX approaches, structured with the Builder design pattern.
4. **Validate with Unit Tests**: Write comprehensive tests to validate the parsers and ensure correctness.
5. **Log the Execution**: Implement logging with Log4J2 or SLF4J for debugging and monitoring.

Follow these steps to create and manage a robust XML-based representation of bank deposits.
