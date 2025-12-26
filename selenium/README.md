Модуль selenium

test1
Используются экземплят класса ChromeDriver из упаковки.
Результат
org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element is not clickable at point (348, 14691)

test2
Используются экземплят класса ChromeDriver и неявное ожидание.
Результат
org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element is not clickable at point (348, 14650)

test3
Используются экземплят класса ChromeDriver и экземпляр класса WebDriverWait с явным ожиданием, что элемент elementToBeClickable.
Результат
org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element is not clickable at point (348, 14440)

test4
Используются экземплят класса ChromeDriver и экземпляр класса FluentWait.
Результат
org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element is not clickable at point (348, 14528)

Визуальное наблюдение демонстрирует, что страница не прокручивается до конца вниз.

Будем пробовать прокрутить страницу до требуемого веб-элемента.

test5
Используются экземплят класса ChromeDriver и экземпляр класса FluentWait и возможность прокрутки с помощью методов класса Actions.
Выполняем прокрутку до поля ввода email для новостной рассылки.
Результат
Кнопка SignUp начинает работать!
Теперь необходимо дождаться появления текстового сообщения.

test6
Улучшенная версия test5 с явым ожиданием сообщения.
Результат
TEST PASSED
