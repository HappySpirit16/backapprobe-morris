#!/usr/bin/env node
import * as cdk from 'aws-cdk-lib';
import { CdkStack } from '../lib/cdk-stack';

const app = new cdk.App();


const environment = "dev";

const project = "morris"
const region = "us-east-1"

export function createName(resource: string, functionality: string, caseType: string = "kebab") {
	if (caseType === "camel") {
		function capF(val: string) {
			return String(val).charAt(0).toUpperCase() + String(val).slice(1);
		}
		return `${capF(project)}${capF(region)}${capF(resource)}${capF(environment)}${capF(functionality)}`
			.split('-').join('');
	} if (caseType === "nodash") {
		return `${project}${region}${resource}${environment}${functionality}`;
	} else {
		return `${project}-${region}-${resource}-${environment}-${functionality}`;
	}
}
new CdkStack(app, createName("dw", "stack"));