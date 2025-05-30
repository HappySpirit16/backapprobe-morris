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
    
    const createCampanaLambda2 = new lambda.Function(this, createName("lambda", "Ecollet"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'com.approbe.ecollet.EcolletHandler::handleRequest',
      functionName: createName("lambda", "Ecollet"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../build/Ecollet/Ecollet.zip")),
      role: lambdaRole,
    });
    
    const createCampanaLambda = new lambda.Function(this, createName("lambda", "prueba"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'com.lomincosoft.validateidentity.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "create-campana"),
      code: lambda.Code.fromAsset(path.join(__dirname, "/../../ValidateIdentity/ValidateIdentity.zip")),
      role: lambdaRole,
    });  

    */

    const zipPath = path.join(__dirname, "../../build/ValidateIdentity/ValidateIdentity.zip");

    if (!fs.existsSync(zipPath)) {
      console.error("❌ No se encontró el archivo ZIP en:", zipPath);
      throw new Error(`Archivo ZIP no encontrado: ${zipPath}`);
    }

    console.log("✅ Archivo ZIP encontrado en:", zipPath);
    
    const createCampanaLambda = new lambda.Function(this, createName("lambda", "validateidentity-test"), {
      runtime: lambda.Runtime.JAVA_11,
      handler: 'com.lomincosoft.validateidentity.LambdaFunctionHandler::handleRequest',
      functionName: createName("lambda", "validateidentity-test"),
      code: lambda.Code.fromAsset(path.join(__dirname, "../../build/ValidateIdentity/ValidateIdentity.zip")),
      role: lambdaRole,
    });                                                 

  }
}
