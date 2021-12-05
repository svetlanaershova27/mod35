#Gherkin
Feature: Find bouquet
  #Позитивный сценарий: выбираем  букет по классификации и получаем уведомление о добавлении товара в корзину
  Scenario: chose a bouquet
    Given url of website 'https://florcat.ru/'
    When  chose an item on the main page
    Then chose the first item
    And add item to card
    Then assert that user was notified with message 'Букет добавлен в корзину'
  #Негативный сценарий: выбираем позиции для букета, которого нет в наличии
  Scenario: chose a bouquet for special edition
    Given url of website 'https://florcat.ru/'
    When  chose an item applying  filters
    Then assert that user saw message 'К сожалению мы ничего не нашли'