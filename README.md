## Исключения в программировании и их обработка (семинары)

Продвинутая работа с исключениями в Java

Написать программу на Java которая будет принимать строку содержащую следующие данные разделенные пробелом: Фамилию, Имя, Отчество, Дату рождения, Номер телефона, Пол. 

Приложение должно распознать в веденной строке какие данные относятся к "Фамилия", какие данные относятся к "Имя", какие данные относятся к "Отчество", какие данные относятся к "Дата рождения", какие данные относятся к "Номер телефона", какие данные относятся к Пол, даже если данные расположены в произвольном порядке.

Для каждой строки данных создать текстовый файл с названием из "Фамилия", вывести распознанные данные в этот файл в формате:
<Фамилия><Имя><Отчество><датарождения><номертелефона><пол>

Например:
<Smith><Alex><Malcovich><22.01.2000><88002000600><M>

Если "Фамилия" дублируется и файл с этой фамилией уже создан дозаписать данные в уже созданный файл на новой строке.

Если при распозновании данных будет ошибка из за неправильного формата введенных данных, бросить исключение, обработать его, вывести пользователю какие данные введены неверно.

Если в веденной строке содержаться не все ожидаемые данные, бросить исключение, обработать его, вывести пользователю сообщение о том что в введенной строке содержится неверное количество данных.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.


1. Data Identification:

    Last Name is the first word in the source text, First Name is the second word in the source text, and Middle Name is the third word in the source text.

    Date of Birth: format dd.mm.yyyy

    Phone number: A number with a length of 11, format 8XXXXXXXXXX

    Names (First, Last, Middle): consist of alphabets.

    Gender: Can be 'M' or 'F'.

2. File Operations:
        
    File will be created in the same directory as the source file.
    If a file with "Last Name" exists, the data should be added to it from a new line.

3. Input Source and Program Flow:

The data is transmitted to the user input program

The program must keep running and accept many lines to be processed one by one. Terminate only when Stop is entered on the command line

4. Data Handling:

    'Middle Name' and 'Father's Name' and 'Paternity' are the same thing. I suggest we use Middle Name everywhere

    multiple middle names cannot be.

5. Exception Handling:

    show errors only to the user
