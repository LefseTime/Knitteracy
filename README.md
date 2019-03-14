# [Knitteracy](http://www.knitteracy.com/ "Deployment at knitteracy.com via Heroku")

>## Technologies:
>- Java
>- Spring Boot
>- Spring Security
>- JavaScript / JQuery
>- MySQL
>- Thymeleaf
>- HTML
>- CSS 

Knitteracy is a full stack app that generates text knitting charts in a variety of fonts.
    
![Knitteracy Landing Page](/images/landing.png "Knitteracy landing page")

Users input text, kerning (space between letters), and spacing (space between words). A MySQL database of letters is queried for each input letter in each font, then tables are constructed in JQuery to display the knitting chart in a variety of fonts. The height and width of each chart in number of stitches is displayed, along with a link to the source of each font.

![Knitteracy charts generated in two fonts](/images/happyholidays.png "Charts in two fonts generated from user input")

Users can optionally create an account to save charts they've generated. Accounts are protected with Spring Security.

![Knitteracy login page](/images/login.png "Login page with inputs for username and password")