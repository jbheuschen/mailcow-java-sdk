/**
 * This package contains the validator included within this sdk. The validator classes are used
 * by MailcowModels (especially their builders) to ensure all required fields are set before sending
 * an object to the server. Moreover, checks on the content of fields can be performed; i.e., strings
 * can be checked for their length (or emptiness), numbers can be checked for a minimal or maximal number
 * or objects can be proven not to be null (i.e., they are "set").
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
package de.fheuschen.mailcow.sdk.validation;