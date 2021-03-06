# Проект по автоматизации для мобильного приложения Wikipedia
![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_wikipedia_logo.png)
## :pushpin: Используемые технологии и инструменты
![Java](https://github.com/vapolonov/vapolonov/blob/main/vasvap_java_logo.png "Java")&nbsp;
![IntelliJ IDEA](https://github.com/vapolonov/vapolonov/blob/main/vasvap_idea_logo.png "IntelliJ IDEA")&nbsp;
![Selenide](https://github.com/vapolonov/vapolonov/blob/main/vasvap_selenide_logo.png "Selenide")&nbsp;
![Gradle](https://github.com/vapolonov/vapolonov/blob/main/vasvap_gradle_logo.png "Gradle")&nbsp;
![JUnit5](https://github.com/vapolonov/vapolonov/blob/main/vasvap_junit5_logo.png "JUnit5")&nbsp;
![Appium](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_appium_logo.png "Appium")&nbsp;
![Browserstack](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_bstack_logo.png "Browserstack")&nbsp;
![Allure Reports](https://github.com/vapolonov/vapolonov/blob/main/vasvap_allure_logo.png "Allure Reports")&nbsp;
![Allure TestOps](https://github.com/vapolonov/vapolonov/blob/main/vasvap_allure_logo_l.png "Allure TestOps")&nbsp;
![GitHub](https://github.com/vapolonov/vapolonov/blob/main/vasvap_github_logo.png "GitHub")&nbsp;
![Jenkins](https://github.com/vapolonov/vapolonov/blob/main/vasvap_jenkins_logo.png "Jenkins")&nbsp;
![Selenoid](https://github.com/vapolonov/vapolonov/blob/main/vasvap_selenoid_logo.png "Selenoid")&nbsp;
![Jira](https://github.com/vapolonov/vapolonov/blob/main/vasvap_jira_logo.png "Jira")&nbsp;
![Telegram](https://github.com/vapolonov/vapolonov/blob/main/vasvap_telegram_logo.png "Telegram")&nbsp;

> Автотесты написаны на ***`Java`*** с использованием фреймворка ***`Selenide`***.
>
> Для сборки проекта используется ***`Gradle`***.
>
> Для автоматизации тестирования мобильного приложения используется ***`Appium`*** - кроссплатформенный инструмент с открытым исходным кодом
>
> ***`JUnit 5`*** используется как фреймворк для модульного тестирования.
>
> Запуск тестов выполняется из ***`Jenkins`***.
>
> ***`Selenoid`*** используется для запуска браузеров в контейнерах ***`Docker`***.
> 
> ***`BrowserStack`*** используется для запуска приложения на удаленном мобильном устройстве.
>
> ***`Allure Report`***, ***`Allure TestOps`***, ***`Jira`***, ***`Telegram Bot`*** используются для визуализации результатов тестирования.

## :rocket: Реализованы следующие проверки
### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; UI
> :heavy_check_mark: Отображение результатов поиска
> 
> :heavy_check_mark: Проверка первых четырех экранов Getting Started
>
>:heavy_check_mark: Изменение темы оформления приложения
>
>:heavy_check_mark: Добавление дополнительного языка приложения - "Русский"

## :computer: Запуск тестов из терминала

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :arrow_down: Запуск тестов с заполненным remote.properties:

```bash
gradle clean ${DEVICE_TEST} -DdeviceHost=${DEVICE_HOST}
```
> где
> ***`DEVICE_TEST`*** - список тестов, сгруппированных по параметру тега. В зависимости от выбранного параметра, будут запускаться определенные группы тестов.
> ***`DEVICE_HOST`*** - список параметров для запуска приложения. В зависимости от выбранного параметра, приложение будет запускаться на соответствующих стендах.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :arrow_down: Формирование отчета allure:
```bash
allure serve build/allure-results
```
## ![](https://github.com/vapolonov/vasvap_diploma/blob/main/img/vasvap_jenkins_logo.png)&nbsp; Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/vasvap_diploma_mobile/)

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_allure.jpg)

После завершения сборки для просмотра результатов необходимо напротив нужной сборки кликнуть на значок ![](https://github.com/vapolonov/vasvap_diploma/blob/main/img/vasvap_testops_logo.png) Allure Report

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_allure2.jpg)

## ![](https://github.com/vapolonov/vasvap_diploma/blob/main/img/vasvap_testops_logo.png) Просмотр отчета о результатах прохождения тестов в [Allure Report](https://jenkins.autotests.cloud/job/vasvap_diploma_mobile/18/allure/)

### :pushpin: Общая информация

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_allure3.jpg)

### :pushpin: Список тестов c описанием шагов и визуализацией результатов

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_allure4.jpg)

### ![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_bstack_logo_s.png)&nbsp; Демонстрация прохождения теста в Browserstack

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/browserstack.gif)

## ![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_bstack_logo_s.png)&nbsp; Список тестов в прогоне на Browserstack

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_browserstack.jpg)

## ![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_bstack_logo_s.png)&nbsp; Подробности и визуализация тестов в Browserstack

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_browserstack2.jpg)

## ![](https://github.com/vapolonov/vasvap_diploma/blob/main/img/vasvap_allure_logo.png) Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/1049/dashboards)

### :pushpin: Главный дашборд

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_testops.jpg)

### :pushpin: Запуски прогонов тестов

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_testops2.jpg)

### :pushpin: Список тест-кейсов

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_testops3.jpg)

## ![](https://github.com/vapolonov/vasvap_diploma/blob/main/img/vasvap_jira_logo.png) Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-352)

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_jira.jpg)

## ![](https://github.com/vapolonov/vasvap_diploma/blob/main/img/vasvap_telegram_logo.png) Уведомления о прохождении тестов в Телеграм

![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_telegram1.png)
![](https://github.com/vapolonov/vasvap_mobile_tests/blob/main/img/vasvap_mobile_telegram3.jpg)

:heart: <a target="_blank" href="https://t.me/vasiliy_apolonov">@vasiliy_apolonov</a>
