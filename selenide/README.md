Модуль selenide

test1
Используется selenide из упаковки.
Результат
Invalid element state [button[form='sib-form']]: element click intercepted: Element is not clickable at point (283, 680)
Caused by: ElementClickInterceptedException: element click intercepted: Element is not clickable at point (283, 680)

test2
Используется selenide из упаковки и ожидание веб-элемента, кнопка shouldBe(clickable).
Результат
Invalid element state [button[form='sib-form']]: element click intercepted: Element is not clickable at point (283, 14425)
Caused by: ElementClickInterceptedException: element click intercepted: Element is not clickable at point (283, 14425)

Визуальное наблюдение демонстрирует, что страница не прокручивается до конца вниз.

Будем пробовать прокрутить страницу до требуемого веб-элемента (а точнее до поля ввода email для подписки).

test3
Используется selenide из упаковки и ожидание веб-элемента.
Результат
Кнопка SignUp начинает работать!
Теперь необходимо дождаться появления текстового сообщения.

test4
Улучшенная версия test3 с явым ожиданием сообщения shouldBe(visible).
Результат
TEST PASSED
