variable "prop_tags" {
  description = "Tags"
  type = map(string)
  default = {
      Project = "Codebuild Terraform"
      IaC = "Terraform"
  }
}

variable "account_id" {
  description = "AWS Account ID"
  type = string
}

variable "codebuild_name" {
  description = "Codebuild project name"
  type = string
}

variable "codebuild_params" {
  description = "Codebuild parameters"
  type = map(string)
}

variable "environment_variables" {
  description = "Environment variables"
  type = map(string)
}