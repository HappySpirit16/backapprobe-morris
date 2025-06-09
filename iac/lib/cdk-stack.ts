import * as cdk from 'aws-cdk-lib';
import { Construct } from 'constructs';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import { createName } from "../bin/cdk";
import * as path from 'path';
import * as iam from "aws-cdk-lib/aws-iam";
import * as fs from 'fs';

export class CdkStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    // Creamos un rol para asignarlo a la función lambda
    const lambdaRole = new iam.Role(this, createName("lambda", "role-base-backapprobe"), {
      assumedBy: new iam.ServicePrincipal("lambda.amazonaws.com"),
      roleName: createName("lambda", "role-base-backapprobe"),
      description: "Rol de IAM para que las funciones lambda puedan ejecutarse.",
    });

        // Politicas al rol creado
        const awsManagedPolicies = [
          'service-role/AWSLambdaBasicExecutionRole',
          'CloudWatchLambdaInsightsExecutionRolePolicy',
          'AmazonDynamoDBFullAccess',
          'AmazonMQApiFullAccess',
          'AmazonMQFullAccess',
          'AmazonCognitoDeveloperAuthenticatedIdentities',
          'AmazonCognitoPowerUser',
          'SecretsManagerReadWrite'
        ];
        
        for (const name of awsManagedPolicies) {
          lambdaRole.addManagedPolicy(
            iam.ManagedPolicy.fromAwsManagedPolicyName(name)
          );
        }
        
        /*
        // Políticas Customer Managed
        const customerManagedPolicies = [
          'AWSLambdaBasicExecutionRole-efead4fd-cd7f-4f25-ad4b-7857a21fcd52',
          'lambdaInvocation', 
          'lambdaInvoke' 
        ];
        
        for (const name of customerManagedPolicies) {
          const arn = Stack.of(this).formatArn({
            service: 'iam',
            resource: 'policy',
            resourceName: name,
            region: '', 
          });
        
          lambdaRole.addManagedPolicy(
            iam.ManagedPolicy.fromManagedPolicyArn(this, `${name}Policy`, arn)
          );
        }
        */

    const zipPath = path.join(__dirname, "/../../build/co.approbe.cognito/co.approbe.cognito.zip");

    if (!fs.existsSync(zipPath)) {
      console.error("❌ No se encontró el archivo ZIP en:", zipPath);
      throw new Error(`Archivo ZIP no encontrado: ${zipPath}`);
    }

    console.log("✅ Archivo ZIP encontrado en:", zipPath);
    
    const createCampanaLambda0 = new lambda.Function(this, createName("lambda", "authorization"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'com.approbe.cognito.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "authorization"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.authorization/co.approbe.authorization.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

    const createCampanaLambda1 = new lambda.Function(this, createName("lambda", "cognito"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'com.approbe.cognito.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "cognito"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.cognito/co.approbe.cognito.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda2 = new lambda.Function(this, createName("lambda", "pdf-create"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.create.pdf.Handler::handleRequest',
      functionName: createName("lambda", "pdf-create"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.create.pdf/co.approbe.create.pdf.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda3 = new lambda.Function(this, createName("lambda", "simulator-loan"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.simulator.loan.lambda.HandlerSimulatorLoan::handleRequest',
      functionName: createName("lambda", "simulator-loan"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.simulator.loan/co.approbe.simulator.loan.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=",
      }      
    });

    const createCampanaLambda4 = new lambda.Function(this, createName("lambda", "status-relation"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.status.relation.Handler::handleRequest',
      functionName: createName("lambda", "status-relation"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.status.relation/co.approbe.status.relation.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda5 = new lambda.Function(this, createName("lambda", "summary"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.summary.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "summary"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.summary/co.approbe.summary.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

    /* //Errores con el archivo common
    const createCampanaLambda6 = new lambda.Function(this, createName("lambda", "authentic"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.autentic.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "authentic"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.autentic/co.approbe.autentic.zip")),
      role: lambdaRole,
      environment: {
        AUTH_AUDIENCE: "stag-api.autenticsign.com",
        AUTH_CLIENTID: "nZMaxbmLBA6eZammY0n3BfRrMHD3dS7X",
        AUTH_CLIENTSECRET: "9Nt9vaVKU080C0Amcm0T9tQFe3BZb5DvaWEN1RKZQYfMBpE59XrccbT9pn9Zt0kS",
        AUTH_GRANTTYPE: "client_credentials",
        AUTH_PASS: "a2Vubnkuc2lsdmFAYXBwcm9iZS5jb3xBcHByb2JlIC0gRHV2ZXJhUUF8OTAxNDk5MDM2NXxUaHUgSnVuIDE1IDE5OjQ4OjE2IFVUQyAyMDIzfFFVQjNqdy91RHBBbnk3bUs3TVo4Y2c9PXw=",
        AWS_LAMBDA_EVENT_BODY_SIZE: "9106",
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
        URL_FIRMA: "https://stag-api.autenticsign.com",
        URL_OTP: "https://j4dmk2yez8.execute-api.us-east-1.amazonaws.com/test",
        URL_TOKEN: "https://authorizer.autenticsign.com",
      }
    });
    */

    const createCampanaLambda7 = new lambda.Function(this, createName("lambda", "general-information"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.general.information.Handler::handleRequest',
      functionName: createName("lambda", "general-information"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.general.information/co.approbe.general.information.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

    const createCampanaLambda9 = new lambda.Function(this, createName("lambda", "powwi-auth"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.powwi.auth.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-auth"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.powwi.auth/co.approbe.powwi.auth.zip")),
      role: lambdaRole,
      environment: {
        AUTH_ACCESS_KEY: "AKIA27LFKCXHQJDUZX5X",
        AUTH_HOST: "baasbankingqa.powwi.co",
        AUTH_REGION: "us-east-1",
        AUTH_SECRET_KEY: "xbSqsGvQDZ9F+eqahWCI4+b9xWGm58yjnJYNyvZX",
        AUTH_USERNAME: "BAAS_QA_DUVERA",
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

    const createCampanaLambda8 = new lambda.Function(this, createName("lambda", "additional-information-borrower"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.additional.information.borrower.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "additional-information-borrower"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.additional.information.borrower/co.approbe.additional.information.borrower.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda11 = new lambda.Function(this, createName("lambda", "award"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.award.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "award"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.award/co.approbe.award.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=",
      }      
    });

    const createCampanaLambda10 = new lambda.Function(this, createName("lambda", "chance-cron"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.chance.cron.Handler::handleRequest',
      functionName: createName("lambda", "chance-cron"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.chance.cron/co.approbe.chance.cron.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda13 = new lambda.Function(this, createName("lambda", "consult-account"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.consult.account.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "consult-account"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.consult.account/co.approbe.consult.account.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda12 = new lambda.Function(this, createName("lambda", "core-demographic"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.core.demographic.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "core-demographic"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.core.demographic/co.approbe.core.demographic.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

    const createCampanaLambda25 = new lambda.Function(this, createName("lambda", "core-druo"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.core.movement.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "core-druo"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.core.movement/co.approbe.core.movement.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda24 = new lambda.Function(this, createName("lambda", "core-movement"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.core.movement.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "core-movement"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.core.movement/co.approbe.core.movement.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

    const createCampanaLambda15 = new lambda.Function(this, createName("lambda", "core"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.core.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "core"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.core/co.approbe.core.zip")),
      role: lambdaRole,
      environment: {
        AUDIENCE: "https://sandbox.lms.kordev.io",
        CLIENT_ID: "twMV6kgIwJItbGgHlPUMQTpTfNGgngcD",
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
        SECRET_ID: "F4Vyj_10cNoOr1Mw2A2DSUCTVZJhdWFqLOuKgUJPS6ruRJM65c8S6ZKW2YYV_JTi",
        URL_CORE: "https://sandbox.lms.kordev.io/",
        URL_CORE_TOKEN: "https://auth.kordev.io",
      }      
    });

    const createCampanaLambda14 = new lambda.Function(this, createName("lambda", "pmt"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.pmt.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "pmt"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.pmt/co.approbe.pmt.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

    const createCampanaLambda26 = new lambda.Function(this, createName("lambda", "powwi"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.powwi.auth.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.powwi/co.approbe.powwi.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda16 = new lambda.Function(this, createName("lambda", "powwi-services"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.powwi.auth.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-services"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.powwi.auth/co.approbe.powwi.auth.zip")),
      role: lambdaRole,
      environment: {
        AUTH_ACCESS_KEY: "AKIA27LFKCXHQJDUZX5X",
        AUTH_HOST: "baasbankingqa.powwi.co",
        AUTH_REGION: "us-east-1",
        AUTH_SECRET_KEY: "xbSqsGvQDZ9F+eqahWCI4+b9xWGm58yjnJYNyvZX",
        AUTH_USERNAME: "BAAS_QA_DUVERA",
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
        URL_AWS: "https://vuwnwhdth3.execute-api.us-east-1.amazonaws.com/ApprobeDev/",
        URL_GCP: "https://test.approbe.co/",
      }      
    });

    const createCampanaLambda17 = new lambda.Function(this, createName("lambda", "powwi-transaction"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.powwi.transaction.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-transaction"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.powwi.transaction/co.approbe.powwi.transaction.zip")),
      role: lambdaRole,
      environment: {
        AUTH_ACCESS_KEY: "AKIA27LFKCXHQJDUZX5X",
        AUTH_API: "Basic YXBwcm9iZTphcHByb2Jl",
        AUTH_CUENTA: "(+57)1071041204",
        AUTH_HOST: "baasbankingqa.powwi.co",
        AUTH_IDCUENTA: "901499036",
        AUTH_REGION: "us-east-1",
        AUTH_SECRET_KEY: "xbSqsGvQDZ9F+eqahWCI4+b9xWGm58yjnJYNyvZX",
        AUTH_USERNAME: "BAAS_QA_DUVERA",
        EXCHANGE_NAME: "amq.direct",
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
        MQ_HOST: "b-392c7a2c-8f5e-492d-8f6f-fad96c318a3d.mq.us-east-1.amazonaws.com",
        MQ_PORT: "5671",
        MQ_SECUR: "guestUser123&",
        MQ_USER: "guestUser",
        QUEUE_NAME: "core-queue",
      }      
    });

    
    const createCampanaLambda18 = new lambda.Function(this, createName("lambda", "powwi-update"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.powwi.update.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-update"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.powwi.update/co.approbe.powwi.update.zip")),
      role: lambdaRole,
      environment: {
        AUTH_ACCESS_KEY: "AKIA27LFKCXHQJDUZX5X",
        AUTH_HOST: "baasbankingqa.powwi.co",
        AUTH_REGION: "us-east-1",
        AUTH_SECRET_KEY: "xbSqsGvQDZ9F+eqahWCI4+b9xWGm58yjnJYNyvZX",
        AUTH_USERNAME: "BAAS_QA_DUVERA",
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

    const createCampanaLambda19 = new lambda.Function(this, createName("lambda", "powwi-processactive"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.processactive.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-processactive"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.processactive/co.approbe.processactive.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda23 = new lambda.Function(this, createName("lambda", "search-user"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.searchuser.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "search-user"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.searchuser/co.approbe.searchuser.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

    const createCampanaLambda21 = new lambda.Function(this, createName("lambda", "select-pmt"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.pmt.HandlerPmt::handleRequest',
      functionName: createName("lambda", "select-pmt"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.pmt/co.approbe.pmt.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda22 = new lambda.Function(this, createName("lambda", "CreateEcollet"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.pmt.HandlerPmt::handleRequest',
      functionName: createName("lambda", "CreateEcollet"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.pmt/co.approbe.pmt.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda20 = new lambda.Function(this, createName("lambda", "user-information"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.userInformation.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "user-information"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.userInformation/co.approbe.userInformation.zip")),
      role: lambdaRole,
      environment: {
        JAVA_TOOL_OPTIONS: "-XX:+TieredCompilation -XX:TieredStopAtLevel=1",
      }      
    });

  }
}
