terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.61.0"
    }
  }
}

# Configure the AWS Provider
provider "aws" {
  region = var.region
}

### IAM ###
resource "aws_iam_role" "myroles" {
  name = "myroles"
  assume_role_policy = jsonencode({
    "Version" : "2012-10-17",
    "Statement" : [
      {
        "Effect" : "Allow",
        "Principal" : {
          "Service" : "build.apprunner.amazonaws.com"
        },
        "Action" : "sts:AssumeRole"
      }
    ]
  })
}

resource "aws_iam_role_policy_attachment" "myrolespolicy" {
  role       = aws_iam_role.myroles.id
  policy_arn = "arn:aws:iam::aws:policy/service-role/AWSAppRunnerServicePolicyForECRAccess"
}

resource "aws_apprunner_auto_scaling_configuration_version" "app_runner" {
  auto_scaling_configuration_name = "app_runner_auto_scaling"
  min_size = 1
  max_size = 5
}

resource "aws_apprunner_service" "app_runner" {
  auto_scaling_configuration_arn = aws_apprunner_auto_scaling_configuration_version.app_runner.arn

  service_name = var.service_name

  source_configuration {
    authentication_configuration {
      access_role_arn = aws_iam_role.myroles.arn
    }
    image_repository {
      image_configuration {
        port = "8080"                          
      }

      image_identifier      =  var.image_ecr
      image_repository_type = "ECR"
    }
  }
}

output "apprunner_service_output" {
  value = aws_apprunner_service.app_runner
}
