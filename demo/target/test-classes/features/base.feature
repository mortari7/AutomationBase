@complete
Feature: Teste
    It's a teste case

    Scenario Outline: Scenario Outline name: Teste
        Given that I acess the Mercado Bitcoin site
        And click the allow permission popup
        And I click in the button to login 
        Then I fill the field "<user>"
        And fill the field "<password>"
        And click button Entrar

    Examples:
        | user          | password    | 
        | 25067640898   | 41936719Al  |