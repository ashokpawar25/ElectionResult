# ElectionResult - (Problem Statement)

It's election night! Exciting! We have a feed of election results from a data supplier. 
They will supply us a file which will be updated throughout the night as results come in.

A result will consist of:
 - A constituency
 - A repeating set of pairs with the party code and the votes cast

So for example:

Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP
Pune, INC, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND

Party Codes -

BJP - Bhartiya Janta Party
INC - Indian National Congress
BSP - Bahujan Samaj Party
CPI - Communist Party of India
NCP - Nationalist Congress Party
IND - Independant

We want to transform this into a standard result that shows:

- the constituency name
- translates the party code into a full name
- shows the winner of the constituency
Extensions - 

- shows the share of the vote as a percentage of all the votes cast 
- winning party i.e. party with maximum number of seats

![image](https://github.com/ashokpawar25/ElectionResult/assets/117933840/0121cb84-3b41-4286-881b-2cf4eab8d4f6)


## Process
= Read The result data file.
- Validate the result data.
- Parse/extract the data.
- Store data into database.
- Get result data from database.
- Process data to get the winner for each constituency.
- Display the result.

## Assumption
- There will be limited number of parties, and constituencies , so we can store it as configuration for the validation.

# domain Package - It consist domain models and domain services
## model.entity :

## ResultData
### States
- `private int id`
- `private final String constituencyName`
- `private final Map<String, Integer> data`

### Constructors
- `public ResultData(int id, String constituencyName, Map<String, Integer> data)`
- `public static ResultData create(int id, String constituencyName, Map<String, Integer> data)`

### Behaviors
- `getters and setters`

## model.valueobject :

## Party (Enum)
### Values
- `BJP`: Bhartiya Janta Party
- `INC`: Indian National Congress
- `BSP`: Bahujan Samaj Party
- `CPI`: Communist Party of India
- `NCP`: Nationalist Congress Party
- `IND`: Independent
- `AAP`: Aam Adami Party

### Constructors
- `Party(String fullName)`

### Behaviors
- `public static String getFullName(String code)`

## domain.service

## WinnerEvaluator
### Behaviors
- `public static List<WinnerDto> getWinner(List<ResultData> resultData)`

# controller Package - This package having controller classes

## ResultDataController
### States
- `private final ResultDataService resultDataService`

### Constructors
- `public ResultDataController(ResultDataService resultDataService)`

### Behaviors
- `public Response create(String constituencyName, Map<String, Integer> data)`
- `public List<ResultData> getAllResultData()`

## ElectionManagerController
### States
- `private final ElectionManagerService electionManagerService`

### Constructors
- `public ElectionManagerController(ElectionManagerService electionManagerService)`

### Behaviors
- `public void readFile(String filePath)`
- `public List<WinnerDto> getWinner()`
- `public String displayWinners(List<WinnerDto> winnerList)`

## controller.dto Package - This package consist class to return http status from the controller methods
## Response
### States
- `private final HttpStatus httpStatus`
- `private final String message`

### Constructors
- `public Response(HttpStatus httpStatus, String message)`

## HttpStatus
### Enum Values
- `BAD_REQUEST`
- `OK`

# service Package - Classes from this package are the middalware between controller layer and repository layer

## ResultDataService
### States
- `private final ResultDataRepository resultDataRepository`

### Constructors
- `public ResultDataService(ResultDataRepository resultDataRepository)`

### Behaviors
- `public ResultData create(String constituencyName, Map<String, Integer> data)`
- `public List<ResultData> getAllResultData()`

## ElectionManagerService
### States
- `private final FileReaderService fileReaderService`
- `private final ResultDataService resultDataService`

### Constructors
- `public ElectionManagerService(FileReaderService fileReaderService,ResultDataService resultDataService)`

### Behaviors
- `public void readFile(String filePath)`
- `public List<WinnerDto> getWinner()`
- `public String displayWinners(List<WinnerDto> winnerList)`

## service.io package - All operations related to the file processing .

## FileReaderService
### States
- `private final FileParserService fileParserService`

### Constructors
- `public FileReaderService(FileParserService fileParserService)`

### Behaviors
- `public void readFile(String filePath)`

## InputDataValidatorService
### Behaviors
- `public static boolean validatePartyCode(String partyCode)`
- `public static boolean validateConstituencyName(String constituencyName)`

## FileParserService
### States
- `private final ResultDataService resultDataService`

### Constructors
- `public FileParserService(ResultDataService resultDataService)`

### Behaviors
- `public void parseResultData(String line)`

# Repository Package - Classes from this package interact with the database, performing operations requested by the services.

## InMemoryResultDataRepository
### States
- `private final InMemoryDatabase inMemoryDatabase`

### Constructors
- `public InMemoryResultDataRepository(InMemoryDatabase inMemoryDatabase)`

### Behaviors
- `public ResultData save(ResultData resultData)`
- `public List<ResultData> getAllResultData()`

## FakeInMemoryDatabase
### States
- `private final List<ResultData> resultData`
- `private int resultDataIdCounter = 0`

### Behaviors
- `public ResultData insertIntoResultDataTable(ResultData resultData)`
- `public List<ResultData> getAllResultData()`
