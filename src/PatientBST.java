public class PatientBST {

    // Node class
    class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    Node root;

    // Insert patient
    public void insert(Patient patient) {
        root = insertNode(root, patient);
    }

    private Node insertNode(Node root, Patient patient) {

        if (root == null) {
            return new Node(patient);
        }

        if (patient.patientId < root.patient.patientId) {
            root.left = insertNode(root.left, patient);
        } 
        else if (patient.patientId > root.patient.patientId) {
            root.right = insertNode(root.right, patient);
        } 
        else {
            System.out.println("Patient ID already exists!");
        }

        return root;
    }

    // Search patient
    public Patient search(int patientId) {
        Node result = searchNode(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchNode(Node root, int patientId) {

        if (root == null || root.patient.patientId == patientId) {
            return root;
        }

        if (patientId < root.patient.patientId) {
            return searchNode(root.left, patientId);
        }

        return searchNode(root.right, patientId);
    }

    // In-order traversal
    public void inOrder() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {

        if (root != null) {
            inOrderTraversal(root.left);

            System.out.println(
                root.patient.patientId + " - " +
                root.patient.patientName
            );

            inOrderTraversal(root.right);
        }
    }

    // Delete patient
    public void delete(int patientId) {
        root = deleteNode(root, patientId);
    }

    private Node deleteNode(Node root, int patientId) {

        if (root == null) {
            return null;
        }

        if (patientId < root.patient.patientId) {
            root.left = deleteNode(root.left, patientId);
        } 
        else if (patientId > root.patient.patientId) {
            root.right = deleteNode(root.right, patientId);
        } 
        else {

            // No left child
            if (root.left == null) {
                return root.right;
            }

            // No right child
            if (root.right == null) {
                return root.left;
            }

            // Two children
            Node successor = findMin(root.right);

            root.patient = successor.patient;

            root.right = deleteNode(
                root.right,
                successor.patient.patientId
            );
        }

        return root;
    }

    // Find minimum node
    private Node findMin(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}