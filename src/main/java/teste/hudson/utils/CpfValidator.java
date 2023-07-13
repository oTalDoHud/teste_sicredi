package teste.hudson.utils;

public class CpfValidator {

    public static boolean isValid(String cpf) {
        // Remova qualquer formatação do CPF, como pontos e traços
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifique o tamanho do CPF
        if (cpf.length() != 11) {
            return false;
        }

        // Verifique se todos os números são iguais
        boolean allNumbersAreEqual = cpf.matches("(\\d)\\1{10}");
        if (allNumbersAreEqual) {
            return false;
        }

        // Verifique o dígito verificador
        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        // Verifique o primeiro dígito verificador
        int firstVerifierDigit = digits[9];
        int firstSum = 0;
        for (int i = 0; i < 9; i++) {
            firstSum += digits[i] * (10 - i);
        }
        int firstCheckDigit = 11 - (firstSum % 11);
        if (firstCheckDigit >= 10) {
            firstCheckDigit = 0;
        }
        if (firstCheckDigit != firstVerifierDigit) {
            return false;
        }

        // Verifique o segundo dígito verificador
        int secondVerifierDigit = digits[10];
        int secondSum = 0;
        for (int i = 0; i < 10; i++) {
            secondSum += digits[i] * (11 - i);
        }
        int secondCheckDigit = 11 - (secondSum % 11);
        if (secondCheckDigit >= 10) {
            secondCheckDigit = 0;
        }
        if (secondCheckDigit != secondVerifierDigit) {
            return false;
        }

        // CPF válido
        return true;
    }
}
