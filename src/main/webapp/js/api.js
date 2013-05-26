function makeExperimentApiUrl(experimentId) {
    if (experimentId)
        return window.experimentsApiUrl + '/' + experimentId;
    else
        return window.experimentsApiUrl;
}
function makeCalculationApiUrl(calculationId) {
    if (calculationId)
        return window.calculationsApiUrl + '/' + calculationId;
    else
        return window.calculationsApiUrl;
}
function makeAlgorithmApiUrl(algorithmId) {
    if (algorithmId)
        return window.algorithmsApiUrl + '/' + algorithmId;
    else
        return window.algorithmsApiUrl;
}
function makeImportApiUrl(importId) {
    if (importId)
        return window.importsApiUrl + '/' + importId;
    else
        return window.importsApiUrl;
}
function makeCompoundSetApiUrl(compoundSetId) {
    if (compoundSetId)
        return window.compoundSetsApiUrl + '/' + compoundSetId;
    else
        return window.compoundSetsApiUrl;
}
function makeVariableApiUrl(variableId) {
    if (variableId)
        return window.variablesApiUrl + '/' + variableId;
    else
        return window.variablesApiUrl;
}
function makeConstantTemplateApiUrl(templateId) {
    if (templateId)
        return window.constantTemplatesApiUrl + '/' + templateId;
    else
        return window.constantTemplatesApiUrl;
}
function makeActiveUserMappingApiUrl() {
    return window.activeUserMappingsApiUrl;
}
