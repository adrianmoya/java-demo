terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "~> 4.0.1"
    }
  }
}

resource "azurerm_resource_group" "java-demo" {
  name     = var.resource_group
  location = var.location

  tags = {
    "Terraform" = "true"
  }
}

resource "azurerm_log_analytics_workspace" "java-demo" {
  name                = "acctest-01"
  location            = azurerm_resource_group.java-demo.location
  resource_group_name = azurerm_resource_group.java-demo.name
  sku                 = "PerGB2018"
  retention_in_days   = 30
}

resource "azurerm_container_app_environment" "java-demo" {
  name                       = "Java-Demo-Environment"
  location                   = azurerm_resource_group.java-demo.location
  resource_group_name        = azurerm_resource_group.java-demo.name
  log_analytics_workspace_id = azurerm_log_analytics_workspace.java-demo.id
}
resource "azurerm_container_app" "java-demo" {
  name                         = "java-demo-app"
  container_app_environment_id = azurerm_container_app_environment.java-demo.id
  resource_group_name          = azurerm_resource_group.java-demo.name
  revision_mode                = "Single"

  template {
    container {
      name   = "examplecontainerapp"
      image  = "mcr.microsoft.com/k8se/quickstart:latest"
      cpu    = 0.25
      memory = "0.5Gi"
    }
  }
}