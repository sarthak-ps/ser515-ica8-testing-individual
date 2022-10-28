# ser515-ica8-testing-individual

### Author: Sarthak Patel

### Program Flow
---
1. Run `main` function in `src/main/java/Urinals.java`
2. In the console that appears, choose `1: Manual Keyboard Input` or `2: Read Input Strings From File` located at `src/main/resources/urinal.dat`
3. To provide custom input file, replace `urinal.dat` in `src/main/resources`.
4. Output file `rule.txt` with incremental suffix is generated in `src/main/java`.

### Tests
---

#### Input String Validity
1. Input String is Null
2. Input String is Empty
3. Input String is Blank (contains whitespace characters only)
4. Input String Contains Characters Other Than (0/1)
5. Input String Has Two Consecutive Urinals Occupied (Invalid String)

#### Opening Input File
1. File Not Found At Given Path
2. File Is Empty
3. File Found At Given Path And Opened Successfully

#### Reading Input File
1. File Ends With -1
2. File Ends With Implicit EOF
3. File Ends With Explicit EOF Token

#### Create And Write To Output File
1. Unique File is Created Each Time With `rule` prefix and `.txt` suffix
2. Output is Written To File Properly

#### Count Available Urinal Spaces
1. 0/1 Urinal Available
2. 1/1 Urinal Available
3. 1/2 Urinal Available
4. 0/2 Urinal Available
5. Long Input String Urinal Availablility
6. Long Input String Urinal Unavailability
