codebuild_name = "codebuild-apilancamento-terraform"

account_id = "XXXXXXXX"
codebuild_params = {
      "NAME" = "codebuild-apilancamento-terraform"
      "GIT_REPO" = "https://github.com/eltongoncalves/desafio_mttechne.git"
      "IMAGE" = "aws/codebuild/standard:4.0"
      "TYPE" = "LINUX_CONTAINER"
      "COMPUTE_TYPE" = "BUILD_GENERAL1_SMALL"
      "CRED_TYPE" = "CODEBUILD"
  } 
environment_variables = {
      "AWS_DEFAULT_REGION" = "us-east-1"
      "AWS_ACCOUNT_ID" = "XXXXXX"
      "IMAGE_REPO_NAME" = "apilancamento"
      "IMAGE_TAG" = "latest"
  }

