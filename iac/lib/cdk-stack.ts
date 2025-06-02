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
    const lambdaRole = new iam.Role(this, createName("lambda", "role-base"), {
      assumedBy: new iam.ServicePrincipal("lambda.amazonaws.com"),
      roleName: createName("lambda", "role-base"),
      description: "Rol de IAM para que las funciones lambda puedan ejecutarse.",
    });

    // Añademos Managed Policies al rol de IAM
    lambdaRole.addManagedPolicy(
      iam.ManagedPolicy.fromAwsManagedPolicyName(
        'CloudWatchLambdaInsightsExecutionRolePolicy',
      )
    );
    lambdaRole.addManagedPolicy(
      iam.ManagedPolicy.fromAwsManagedPolicyName(
        'service-role/AWSLambdaBasicExecutionRole',
      )
    );
    lambdaRole.addManagedPolicy(
      iam.ManagedPolicy.fromAwsManagedPolicyName(
        'service-role/AWSLambdaBasicExecutionRole',
      )
    )

    /* //Creando lambdas
    
    const createCampanaLambda = new lambda.Function(this, createName("lambda", "prueba"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'com.lomincosoft.validateidentity.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "create-campana"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/ValidateIdentity/ValidateIdentity.zip")),
      role: lambdaRole,
    });   
    
    */

    const zipPath = path.join(__dirname, "/../../build/co.approbe.cognito/co.approbe.cognito.zip");

    if (!fs.existsSync(zipPath)) {
      console.error("❌ No se encontró el archivo ZIP en:", zipPath);
      throw new Error(`Archivo ZIP no encontrado: ${zipPath}`);
    }

    console.log("✅ Archivo ZIP encontrado en:", zipPath);
    
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
    });

    /*
    const createCampanaLambda6 = new lambda.Function(this, createName("lambda", "authentic"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.autentic.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "authentic"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.autentic/co.approbe.autentic.zip")),
      role: lambdaRole,
    });
    */

    const createCampanaLambda7 = new lambda.Function(this, createName("lambda", "general-information"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.general.information.Handler::handleRequest',
      functionName: createName("lambda", "general-information"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.general.information/co.approbe.general.information.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda8 = new lambda.Function(this, createName("lambda", "additional-information-borrower"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.additional.information.borrower.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "additional-information-borrower"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.additional.information.borrower/co.approbe.additional.information.borrower.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda9 = new lambda.Function(this, createName("lambda", "powwi-auth"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.powwi.auth.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-auth"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.powwi.auth/co.approbe.powwi.auth.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda10 = new lambda.Function(this, createName("lambda", "chance-cron"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.chance.cron.Handler::handleRequest',
      functionName: createName("lambda", "chance-cron"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.chance.cron/co.approbe.chance.cron.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda11 = new lambda.Function(this, createName("lambda", "award"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.award.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "award"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.award/co.approbe.award.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda12 = new lambda.Function(this, createName("lambda", "core-demographic"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.core.demographic.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "core-demographic"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.core.demographic/co.approbe.core.demographic.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda13 = new lambda.Function(this, createName("lambda", "consult-account"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.consult.account.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "consult-account"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.consult.account/co.approbe.consult.account.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda14 = new lambda.Function(this, createName("lambda", "pmt"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.pmt.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "pmt"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.pmt/co.approbe.pmt.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda15 = new lambda.Function(this, createName("lambda", "core"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.core.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "core"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.core/co.approbe.core.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda16 = new lambda.Function(this, createName("lambda", "powwi-services"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.powwi.auth.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-services"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.powwi.auth/co.approbe.powwi.auth.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda17 = new lambda.Function(this, createName("lambda", "powwi-transaction"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.powwi.transaction.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-transaction"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.powwi.transaction/co.approbe.powwi.transaction.zip")),
      role: lambdaRole,
    });

    /*
    const createCampanaLambda18 = new lambda.Function(this, createName("lambda", "powwi-update"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.powwi.update.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-update"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.powwi.update/co.approbe.powwi.update.zip")),
      role: lambdaRole,
    });
    */

    const createCampanaLambda19 = new lambda.Function(this, createName("lambda", "powwi-processactive"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.processactive.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "powwi-processactive"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.processactive/co.approbe.processactive.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda20 = new lambda.Function(this, createName("lambda", "user-information"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.userInformation.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "user-information"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.userInformation/co.approbe.userInformation.zip")),
      role: lambdaRole,
    });

    const createCampanaLambda21 = new lambda.Function(this, createName("lambda", "select-pmt"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'co.approbe.pmt.HandlerPmt::handleRequest',
      functionName: createName("lambda", "select-pmt"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/co.approbe.pmt/co.approbe.pmt.zip")),
      role: lambdaRole,
    });

  }
}
