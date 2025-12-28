Feature: test my api + db setup

  @wip
  Scenario: store random people to DB 1
    Given I store database row count as "initial_row_count"
    Given I request 2 random people from API as "random_group_1"
    When I store "random_group_1" in DB and new entries count is "new_entries_count"
    Then DB "initial_row_count" has "new_entries_count" more rows
