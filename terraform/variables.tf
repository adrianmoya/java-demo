variable "resource_group" {
  description = "The resource group"
  default = "RG1"
}

variable "application_name" {
  description = "The Spring Boot application name"
  default     = "Demo Java"
}

variable "location" {
  description = "The Azure location where all resources in this example should be created"
  default     = "Central US"
}
