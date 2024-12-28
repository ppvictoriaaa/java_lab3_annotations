_**Автор**: Вікторія Пекур_

_**Група**: ІО-24_

_**Залікова книжка:** №2420_


**Лабораторна робота №3**

**Тема:** Анотації і кодогенерація в Java

**Варіант:** 2420 % 3 = 2

**Опис програми:**

Програма виконує валідацію об'єктів класів Person, Car та Medicine, використовуючи анотації, також програма має клас AnnotationProcess, що забезпечує перевірку використання анотацій на моменті компіляції

Кожен клас має аннотації для валідації полів, такі як:

1) @NotNull для перевірки на null

2) @StringLength для перевірки довжини рядка,

3) @MinValue і @MaxValue для перевірки значень числових полів.

Також програма генерує SQL запити INSERT і DELETE, перед INSERT якраз здійснюється валідація та під час компіляції відбувається перевірка типів даних, до яких застосовуються анотації, використовуючи annotation processor.

Тестування програми:

1) Створимо об'єкти кожного класу в Main:

![Main.PNG](screens%2FMain.PNG)

2) Перед виконанням переглянемо стан таблиць на даний момент:

Таблиця об'єктів класу Car:

![carsBeforeINSERT.PNG](screens%2FcarsBeforeINSERT.PNG)

Таблиця об'єктів класу Person:

![personsBeforeINSERT.PNG](screens%2FpersonsBeforeINSERT.PNG)

Таблиця об'єктів класу Medicine:

![medicinesBeforeINSERT.PNG](screens%2FmedicinesBeforeINSERT.PNG)

3) Запустимо програму:
![INSERTconsole.PNG](screens%2FINSERTconsole.PNG)
Бачимо, що останній елемент не пройшов валідацію, тому доданий до таблиці не був
4) Перевіримо SQL таблиці:

Таблиця об'єктів класу Car:

![carsAfterINSERT.PNG](screens%2FcarsAfterINSERT.PNG)

Таблиця об'єктів класу Person:

![personsAfterINSERT.PNG](screens%2FpersonsAfterINSERT.PNG)

Таблиця об'єктів класу Medicine:

![medicinesAfterINSERT.PNG](screens%2FmedicinesAfterINSERT.PNG)

Усі об'єкти були успішно додані

5) Проведемо видалення об'єктів з таблиць за їх id:
![DELETEconsole.PNG](screens%2FDELETEconsole.PNG)
6) Перевіримо результат:

Таблиця об'єктів класу Car:

![carsAfterDELETE.PNG](screens%2FcarsAfterDELETE.PNG)

Таблиця об'єктів класу Person:

![personsAfterDELETE.PNG](screens%2FpersonsAfterDELETE.PNG)

Таблиця об'єктів класу Medicine:

![medicinesAfterDELETE.PNG](screens%2FmedicinesAfterDELETE.PNG)

Отримали очікувані результати


Для перевірки анотацій на моменті компіляції створимо тестовий клас Test та помилково застосуємо анотацію MaxValue до поля типу String:

![ERRORcompile.PNG](screens%2FERRORcompile.PNG)

Отримали помилку, яку було вказано в класі AnnotationProcessor


**Запуск програми**

Для запуску програми необхідно виконати команду _mvn package_ для модуля Annotations-Testing для створення виконуваного jar файлу (у випадку внесення змін до коду)

Наступним етапом є запуск виконуваного jar файлу, для зручності було створено бат файл [run.bat](Annotations-Testing%2Frun.bat)

**Висновок:**

Програма успішно реалізує валідацію об'єктів класів Person, Car та Medicine за допомогою анотацій (@NotNull, @StringLength, @MinValue, @MaxValue). Використання класу AnnotationProcess дозволяє перевіряти анотації на етапі компіляції. Тестування показало, що валідація коректно відкидає невірні дані, а валідні об'єкти додаються до бази. Програма також генерує правильні SQL запити для вставки та видалення об'єктів і обробляє помилки компіляції при невідповідності типів даних.



